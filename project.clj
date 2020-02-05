(defproject api_rest_products_with_clojure "0.1.0-SNAPSHOT"
  :description "API REST for Products using Clojure"
  :url "https://www.linkedin.com/in/paluan-batista-a47b9710a/"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-json "0.5.0"]
                 [korma "0.3.0-RC5"]
                 [org.postgresql/postgresql "42.2.9"]
                 [ring/ring-defaults "0.3.2"]]
  :main ^:skip-aot api-rest-products-with-clojure.core
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler api-rest-products-with-clojure.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})