(ns reframe-figwheel-main.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))

(reg-sub
 :active-content
 (fn [db _]
   (:active-content db)))

(reg-sub
 :update-user-profile!
 (fn [db _]
   (:user-profile db)))
