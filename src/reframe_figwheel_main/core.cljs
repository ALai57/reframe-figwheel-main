(ns reframe-figwheel-main.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [goog.events :as events]
            [reframe-figwheel-main.events.core]
            [reframe-figwheel-main.subs]
            [reframe-figwheel-main.views]
            [reagent.dom :refer [render]]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [secretary.core :as secretary]
            ;;[devtools.core :as devtools]
            )
  (:import [goog History]
           [goog.history EventType]))


(dispatch-sync [:initialize-db])

;; -- Debugging aids ----------------------------------------------------------
;;(devtools/install!)       ;; https://github.com/binaryage/cljs-devtools
(enable-console-print!)   ;; so that println writes to `console.log`

;; -- Routes and History ------------------------------------------------------

(defroute "/" []
  (dispatch [:set-active-panel :home]))
(defroute "/:path" [path]
  (dispatch [:set-active-panel (keyword path)]))

(def history
  (doto (History.)
    (events/listen EventType.NAVIGATE
                   (fn [event] (secretary/dispatch! (.-token event))))
    (.setEnabled true)))


;; -- Entry Point -------------------------------------------------------------
;; Within ../../resources/public/index.html you'll see this code
;;    window.onload = function () {
;;      andrewslai.cljs.core.main();
;;    }
;; So this is the entry function that kicks off the app once HTML is loaded

(defn ^:export main
  []
  ;; `reframe-figwheel-main.views/app` is the root view for the entire UI.
  (render [reframe-figwheel-main.views/app]
          (.getElementById js/document "app")))
