(ns reframe-figwheel-main.pages.home
  (:require [reframe-figwheel-main.navbar :as nav]
            [goog.object :as gobj]
            [re-frame.core :refer [dispatch]]))

(defn home []
  (println "Home")
  [:div
   [nav/primary-nav]])

(comment
  (cljs.pprint/pprint (:resume-info @re-frame.db/app-db))
  )
