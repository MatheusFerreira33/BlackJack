(ns Cards
  (:require [Rules]
            [Cards :as Cards]))

(defn newCard []

  (inc (rand-int 13)))


(defn moreCard [player]
  (let [card (Cards/newCard)
        cards (conj (:cards player) card)
        newPlayer (update player :cards conj card)
        points (Rules/contCards cards)]
    (assoc newPlayer :points points)))
