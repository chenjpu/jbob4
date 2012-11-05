// jbob.web project main.go
package main

import (
	"flag"
	"fmt"
	"net/http"
	//"net/url"
	resource "jbob/http/resource"
	"log"
	"os"
	//"strings"
)

const defaultPort = ":8080" // default webserver address

var (
	// network
	port = flag.String("port", ":8080", "HTTP service Port (e.g., '"+defaultPort+"')")
	dir  = flag.String("dir", "..", "HTTP resource File dir")
)

func usage() {
	fmt.Fprintf(os.Stderr, "usage: \n  jbob.web -port="+defaultPort+"\n")
	flag.PrintDefaults()
	os.Exit(2)
}

func loggingHandler(h http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, req *http.Request) {
		log.Printf("%s\t%s", req.RemoteAddr, req.URL)
		h.ServeHTTP(w, req)
	})
}

func main() {
	flag.Usage = usage
	flag.Parse()
	var handler http.Handler = loggingHandler(http.DefaultServeMux)
	//jfile.Dir("static")
	r := resource.New()
	r.Bind("/static", *dir+"/static")
	http.Handle("/static/", http.FileServer(r))
	http.HandleFunc("/", tt)
	// Start http server.
	//fmt.Println(*dir)
	if err := http.ListenAndServe(*port, handler); err != nil {
		log.Fatalf("ListenAndServe %s: %v", *port, err)
	}
}

func tt(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("jeee"))
}
