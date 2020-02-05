(ns api_rest_products_with_clojure.core
  (:require [compojure.core :refer :all]
     [compojure.handler :as handler]
     [compojure.api.sweet :refer [api routes]]
     [api-rest-products-with-clojure.db :refer [db]]
     [api-rest-products-with-clojure.handler :refer [app-routes]]))

(def swagger-config
  {:ui "/swagger"
   :spec "/swagger.json"
   :options {:ui {:validatorUrl nil}
             :data {:info {:version "1.0.0", :title "API REST Products with Clojure"}}}})

(def app (api {:swagger swagger-config} (apply routes app-routes)))

(defn -main
  [& args]
  (db/postgres-connection)
  (routes app {:port 3000}))