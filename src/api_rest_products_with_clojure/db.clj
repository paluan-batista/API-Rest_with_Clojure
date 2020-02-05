(ns api-rest-products-with-clojure.db
  (:require [korma.db :as korma]
            [korma.core]))

(def postgres-connection 
  (korma/postgres
            {:host "localhost"
             :port "5432"
             :db "api-rest-products-clojure"
             :user "postgres"
             :password "postgres"
             :delimiters ""}))


(korma/defdb db postgres-connection)