(ns reframe-figwheel-main.pages.admin
  (:require [ajax.core :refer [POST]]
            [reframe-figwheel-main.navbar :as nav]
            [goog.object :as gobj]
            [re-frame.core :refer [dispatch subscribe]]))

(defn login-form []
  [:div.login-wrapper
   [:div.login-frame
    [:div.login-header [:h1 "Welcome!"]]
    [:p "Implement your own login functionality!"]
    [:input.btn-secondary
     {:type "button"
      :value "Login"
      :onClick #(dispatch [:login])}]
    [:br]]])

(defn user-profile [{:keys [avatar_url username firstName lastName email] :as user}]
  [:div.user-profile-wrapper
   [:form
    [:img {:src avatar_url
           :style {:width "100px"}}]
    [:img {:id "avatar-preview"
           :name "avatar"
           :style {:width "100px"}}]
    [:br]
    [:br]
    [:br]
    [:dl.form-group
     [:dt [:label {:for "email"} "Email"]]
     [:dd [:input.form-control {:type "text"
                                :readOnly true
                                :value email}]]]
    [:dl.form-group
     [:dt [:label {:for "firstName"} "First name"]]
     [:dd [:input.form-control {:type "text"
                                :readOnly true
                                :value firstName}]]]
    [:dl.form-group
     [:dt [:label {:for "lastName"} "Last name"]]
     [:dd [:input.form-control {:type "text"
                                :readOnly true
                                :value lastName}]]]
    [:br]
    [:br]
    [:input.btn-secondary
     {:type "button"
      :value "Edit profile"
      :style {:float "left"}
      :on-click (fn [& args]
                  (dispatch [:account-management]))}]
    [:input.btn-secondary
     {:type "button"
      :value "Logout"
      :style {:float "right"}
      :on-click (fn [& args]
                  (dispatch [:logout]))}]]])

(defn login-ui []
  (let [user (subscribe [:update-user-profile!])]
    [:div
     [nav/primary-nav]
     [:br]
     (if @user
       [:div [user-profile @user]]
       [login-form])]))
