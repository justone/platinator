(ns platinator.core
  (:gen-class)
  (:require
    [cheshire.core :refer :all]
    [compojure.core :refer [defroutes GET POST]]
    [compojure.handler :refer [site]]
    [compojure.route :as route]
    [ring.util.response :refer [redirect]]
    [org.httpkit.server :refer [run-server]]
    [clojure.string :as string]
    [platinator.reload :as reload]
    [clojure.java.browse :as browse]
    [clojure.java.io :as io]))

; be sure to copy src/testdata.json to /tmp/testdata.json
(def json-path
  "/tmp/testdata.json")

(def users
  (parse-stream (io/reader json-path) true))

(defn find-user-by-email [body]
  (let [email (string/lower-case (:email (parse-string body true)))]
    (generate-string (filter (fn [user]
      (= (string/lower-case (:email user)) email))
      users))))

(defroutes app-routes
  (GET "/" [] (redirect "index.html"))
  (POST "/find" {body :body} (find-user-by-email (slurp body)))
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
