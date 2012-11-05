package resource

import (
	//"errors"
	//"io"
	"fmt"
	"net/http"
	"os"
	"path"
)

type mapping struct {
	path string
	root string
}

func (m *mapping) translate(name string) string {
	name = path.Clean("/" + name)
	return path.Join(m.root, name[len(m.path):])
}

//func (m *mapping) stat(name string) (os.FileInfo, error) {
//   return  os.Stat(m.translate(name))
//}

type resource struct {
	mappings map[string]mapping
}

func New() *resource {
	return &resource{make(map[string]mapping)}
}

func (r *resource) Bind(path, root string) {
	r.mappings[path] = mapping{path, root}
}

func (r *resource) getMapping(name string) (*mapping, error) {
label:
	name = path.Dir(name)
	if value, ok := r.mappings[name]; ok {
		return &value, nil
	}
	if name == "/" {
		return nil, fmt.Errorf("Cannot Find path :%s from mapping :%v", name, r.mappings)
	}
	goto label
}

func (r *resource) Open(name string) (http.File, error) {
	mapping, er := r.getMapping(name)
	if er != nil {
		return nil, er
	}
	name = mapping.translate(name)
	if _, er := os.Stat(name); er != nil {
		return nil, er
	}
	f, er := os.Open(name)
	if er != nil {
		return nil, er
	}
	return &file{f}, nil
}

type file struct {
	*os.File
}

//func (r *file) Close() error {
//
//}
//func (r *file) Stat() (os.FileInfo, error) {
//	return nil, nil
//}
func (r *file) Readdir(count int) ([]os.FileInfo, error) {
	return nil, fmt.Errorf("cannot Readdir from file %s", r.Name())
}

//func (r *file) Read([]byte) (int, error) {
//	return nil, nil
//}
//func (r *file) Seek(offset int64, whence int) (int64, error) {
//	return nil, nil
//}
