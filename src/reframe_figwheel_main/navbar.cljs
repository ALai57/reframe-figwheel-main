(ns reframe-figwheel-main.navbar
  (:require [re-frame.core :refer [dispatch subscribe]]))

(def nav-images-path "images/nav-bar/")

(defn- nav-icon
  [route img]
  [:a.zoom-icon {:href (str "#/" route)}
   [:img.navbutton
    {:src (str nav-images-path img)
     :on-click #(dispatch [:set-active-panel (keyword route)])}]])

(defn- login-icon
  [avatar-url]
  [:a.zoom-icon {:href (str "#/admin")}
   [:img.navbutton
    {:src (or avatar-url "/images/nav-bar/unknown-user.svg")
     :on-click #(dispatch [:set-active-panel :admin])}]])

(defn primary-nav []
  [:div#primary-nav
   [:a.zoom-icon {:href "#/home"
                  :style {:float "left"}}
    [:img.navbutton {:src "images/nav-bar/favicon-white.svg"
                     :on-click #(dispatch [:set-active-panel :home])}]]
   [:div#secondary-nav
    [login-icon nil]
    ;; Add your own nav icons here!
    #_[nav-icon "research" "neuron-icon.svg"]
    #_[nav-icon "data-analysis" "statistics-icon.svg"]]])
