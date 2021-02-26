(ns reframe-figwheel-main.db
  (:require [cljs.spec.alpha :as s]))


;; -- Spec --------------------------------------------------------------------
;; The value in app-db should always match this spec.

(s/def ::active-panel keyword?)
(s/def ::loading boolean?)
(s/def ::db
  (s/keys :req-un [::active-panel
                   ::active-content
                   ::loading?]))

;; -- Default app-db Value  ---------------------------------------------------

(def default-db
  {:active-panel             :home
   :active-content           nil
   :loading?                 false})
