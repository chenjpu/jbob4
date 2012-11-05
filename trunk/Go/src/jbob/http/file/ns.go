package file

import (
	"fmt"
	"io"
	//"io/ioutil"
	//"net/http"
	"os"
	pathpkg "path"
	//"path/filepath"
	"sort" 
	"strings"
	//"time" 
)
const debugNS = false
var (
	ns = nameSpace{} // the underlying file system
)

type mountedFS struct {
	from string
	fs   FileSystem
	to   string
}

type nameSpace map[string][]mountedFS

// translate translates path for use in m, replacing from with to.
//
// mountedFS{"/src/pkg", fs, "/src"}.translate("/src/pkg/code") == "/src/code".
func (m mountedFS) translate(path string) string {
	path = pathpkg.Clean("/" + path)
	return pathpkg.Join(m.to, path[len(m.from):])
}

func (nameSpace) String() string {
	return "ns"
}

// Fprint writes a text representation of the name space to w.
func (ns nameSpace) Fprint(w io.Writer) {
	fmt.Fprint(w, "name space {\n")
	var all []string
	for mtpt := range ns {
		all = append(all, mtpt)
	}
	sort.Strings(all)
	for _, mtpt := range all {
		fmt.Fprintf(w, "\t%s:\n", mtpt)
		for _, m := range ns[mtpt] {
			fmt.Fprintf(w, "\t\t%s %s\n", m.fs, m.to)
		}
	}
	fmt.Fprint(w, "}\n")
}

// clean returns a cleaned, rooted path for evaluation.
// It canonicalizes the path so that we can use string operations
// to analyze it.
func (nameSpace) clean(path string) string {
	return pathpkg.Clean("/" + path)
}
func (ns nameSpace) Bind(from string, newfs FileSystem, to string) {
	from = ns.clean(from)
	to = ns.clean(to)
	m := mountedFS{from, newfs, to}
	var mtpt []mountedFS
	mtpt = append(mtpt, ns.resolve(from)...)
	mtpt = append(mtpt, m)

	// Extend m.from, m.to in inherited mount point entries.
	for i := range mtpt {
		m := &mtpt[i]
		if m.from != from {
			if !hasPathPrefix(from, m.from) {
				// This should not happen.  If it does, panic so
				// that we can see the call trace that led to it.
				panic(fmt.Sprintf("invalid Bind: from=%q m={%q, %s, %q}", from, m.from, m.fs.String(), m.to))
			}
			suffix := from[len(m.from):]
			m.from = pathpkg.Join(m.from, suffix)
			m.to = pathpkg.Join(m.to, suffix)
		}
	}

	ns[from] = mtpt
}

// resolve resolves a path to the list of mountedFS to use for path.
func (ns nameSpace) resolve(path string) []mountedFS {
	path = ns.clean(path)
	for {
		if m := ns[path]; m != nil {
			if debugNS {
				fmt.Printf("resolve %s: %v\n", path, m)
			}
			return m
		}
		if path == "/" {
			break
		}
		path = pathpkg.Dir(path)
	}
	return nil
}

func (ns nameSpace) stat(path string, f func(FileSystem, string) (os.FileInfo, error)) (os.FileInfo, error) {
	var err error
	for _, m := range ns.resolve(path) {
		fi, err1 := f(m.fs, m.translate(path))
		if err1 == nil {
			return fi, nil
		}
		if err == nil {
			err = err1
		}
	}
	if err == nil {
		err = &os.PathError{Op: "stat", Path: path, Err: os.ErrNotExist}
	}
	return nil, err
}

func (ns nameSpace) Stat(path string) (os.FileInfo, error) {
	return ns.stat(path, FileSystem.Stat)
}

func (ns nameSpace) Lstat(path string) (os.FileInfo, error) {
	return ns.stat(path, FileSystem.Lstat)
}

func hasPathPrefix(x, y string) bool {
	return x == y || strings.HasPrefix(x, y) && (strings.HasSuffix(y, "/") || strings.HasPrefix(x[len(y):], "/"))
}
