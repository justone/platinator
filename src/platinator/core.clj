(ns platinator.core
  (:gen-class)
  (:require
    [compojure.core :refer [defroutes GET]]
    [compojure.handler :refer [site]]
    [compojure.route :as route]
    [org.httpkit.server :refer [run-server]]
    [clojure.string :as string]
    [platinator.reload :as reload]
    [clojure.java.browse :as browse]))

(defroutes app-routes
  (GET "/" [] "Platinator")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (site app-routes))

(defn -main [port]
  (reload/start-nstracker)
  (run-server (site #'app-routes) {:port (Integer. port)}))

;(comment
  ;(def stop-dev (dev-server))
  ;(stop-dev)
  ;)
(defn dev-server
  "Start a dev server with live-reload of namespaces"
  []
  (reload/start-nstracker)
  (browse/browse-url "http://localhost:8080/")
  (-main 8080))
