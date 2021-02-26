(ns reframe-figwheel-main.events.core
  (:require [reframe-figwheel-main.db :refer [default-db]]
            [re-frame.core :refer [dispatch reg-event-db]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Helper functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(reg-event-db
 :initialize-db
 (fn [_ _]
   default-db))

(reg-event-db
 :update-user-profile!
 (fn [db [_ userinfo]]
   (assoc db :user-profile userinfo)))

(reg-event-db
 :login
 (fn [db _]
   (println "Login not implemented!")
   db))

(reg-event-db
 :logout
 (fn [db _]
   (dissoc db :user-profile)))

(reg-event-db
 :account-management
 (fn [db _]
   (println "Account management console not implemented!")
   db))

(defn set-active-panel [db [_ value]]
  (merge db {:loading? true
             :active-panel value
             :active-content nil }))
(reg-event-db
  :set-active-panel
  set-active-panel)
