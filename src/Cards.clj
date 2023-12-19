(ns Cards
  (:require [Rules]))

(defn new-card []
  (inc (rand-int 13)))

(defn more-card [player]
  (let [card (new-card)
        cards (conj (:cards player) card)
        points (->> cards
                    (map Rules/convertJQKTo10)
                    (map Rules/cardATo11)
                    (apply +))]
    (assoc player :cards cards :points points)))
