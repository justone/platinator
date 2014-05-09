(ns platinator.core
  (:gen-class)
  (:require
    [compojure.core :refer [defroutes GET]]
    [compojure.handler :refer [site]]
    [compojure.route :as route]
    [ring.util.response :refer [redirect]]
    [org.httpkit.server :refer [run-server]]
    [clojure.string :as string]
    [clojure.java.browse :as browse]))

(defroutes app-routes
  (GET "/" [] (redirect "index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (site app-routes))

(defn -main [port]
  (run-server (site #'app-routes) {:port (Integer. port)}))

;(comment
  ;(def stop-dev (dev-server))
  ;(stop-dev)
  ;)
(defn dev-server
  "Start a dev server with live-reload of namespaces"
  []
  (browse/browse-url "http://localhost:8080/")
  (-main 8080))
