(ns api-rest-products-with-clojure.handler
  (:require [compojure.core :refer :all]
     [compojure.handler :as handler]
     [compojure.route :as route]
     [ring.middleware.json :as json]
     [ring.util.response :refer [response]]
     [api-rest-products-with-clojure.query :refer :all]))

(defroutes app-routes
  (GET "/products" []
        (response (get-products)))

  (GET "/products/:id" [id]
    (response (get-product (Integer/parseInt id))))

  (POST "/add-product" {:keys [params]}
    (let [{:keys [nome quantidade valor]} params]
      (response (add-product nome quantidade valor))))

  (DELETE "/products/:id" [id]
        (response (delete-products (Integer/parseInt id))))

  (PUT "/products/:id" [id nome quantidade valor]
       (response (update-product (Integer/parseInt id) nome quantidade valor)))

  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))