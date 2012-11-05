package file

import (
	"fmt"
	"io"
	//"io/ioutil"
	"flag"
	"net/http"
	"os"
	pathpkg "path"
	"path/filepath"
	"log"
	//"sort"
	//"strings"
	//"time" 
)

var (
	staticPath = flag.String("path", "", "additional static directories (colon-separated)")
	// http handlers
	fileServer http.Handler  // default file server
)

func Dir(root string) FileSystem {
	return dir(root)
}

type dir string

func (root dir) String() string { return "os(" + string(root) + ")" }

func (root dir) resolve(path string) string {
	// Clean the path so that it cannot possibly begin with ../.
	// If it did, the result of filepath.Join would be outside the
	// tree rooted at root.  We probably won't ever see a path
	// with .. in it, but be safe anyway.
	path = pathpkg.Clean("/" + path)

	return filepath.Join(string(root), path)
}

func (root dir) Open(path string) (readSeekCloser, error) {
	f, err := os.Open(root.resolve(path))
	if err != nil {
		return nil, err
	}
	fi, err := f.Stat()
	if err != nil {
		return nil, err
	}
	if fi.IsDir() {
		return nil, fmt.Errorf("Open: %s is a directory", path)
	}
	return f, nil
}

func (root dir) Lstat(path string) (os.FileInfo, error) {
	return os.Lstat(root.resolve(path))
}

func (root dir) Stat(path string) (os.FileInfo, error) {
	return os.Stat(root.resolve(path))
}

type FileSystem interface {
	Open(path string) (readSeekCloser, error)
	Lstat(path string) (os.FileInfo, error)
	Stat(path string) (os.FileInfo, error)
	//ReadDir(path string) ([]os.FileInfo, error)
	String() string
}

type readSeekCloser interface {
	io.Reader
	io.Seeker
	io.Closer
}

type httpFileSystem struct {
	fs FileSystem
}

func (h *httpFileSystem) Open(name string) (http.File, error) {
	_, err := h.fs.Stat(name)
	if err != nil {
		return nil, err
	}
	f, err := h.fs.Open(name)
	if err != nil {
		return nil, err
	}
	return &httpFile{h.fs, f, name}, nil
}

type httpFile struct {
	fs FileSystem
	readSeekCloser
	name string
}

func (h *httpFile) Stat() (os.FileInfo, error) { return h.fs.Stat(h.name) }
func (h *httpFile) Readdir(int) ([]os.FileInfo, error) {
	return nil, fmt.Errorf("cannot Readdir from file %s", h.name)
}

func initHandlers() {
	// Add named directories in -path argument as
	// subdirectories of src/pkg.
	for _, p := range filepath.SplitList(*staticPath) {
		_, elem := filepath.Split(p)
		if elem == "" {
			log.Fatalf("invalid -path argument: %q has no final element", p)
		}
		ns.Bind("/src/pkg/"+elem, Dir(p), "/")
	}

	fileServer = http.FileServer(&httpFileSystem{})
}
