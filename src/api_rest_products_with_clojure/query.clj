(ns api-rest-products-with-clojure.query
  (:require [api-rest-products-with-clojure.db]
            [korma.core :refer :all]))


(defentity products)

;;Return list of products
(defn get-products []
  (select products))

;;Add product
(defn add-product
  [nome quantidade valor]
  (insert products
          (values {:nome nome :quantidade quantidade :valor valor})))

;;Return product for id
(defn get-product [id]
  (first (select products
      (where {:id [= id]}))))

;;Delete product for id
(defn delete-products [id]
  (delete products
          (where {:id [= id]})))

;;Update product
(defn update-product
  [id nome quantidade valor]
  (update products
          (set-fields {:nome nome :quantidade quantidade :valor valor})
          (where {:id [= id]})))