(defproject platinator "0.1.0-SNAPSHOT"
  :description "Platinator: solving the tandem parking problem forever"
  :url "https://github.com/justone/platinator"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [http-kit "2.1.18"]
                 [compojure "1.1.6"]
                 [javax.servlet/servlet-api "2.5"]
                 [ns-tracker "0.2.2"]
                 [ring "1.2.2"]]
  :main platinator.core)
