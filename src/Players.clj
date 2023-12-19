(ns Players
  (:require [Rules :as Rules]
            [Cards :as Cards]))


(defn player [name]
  (let [card1 (Cards/new-card)
        card2 (Cards/new-card)
        cards [card1, card2]
        count (Rules/contCards cards)]
    {:player-name name
     :cards cards
     :points count}))


(defn decisionContinuePlayer [player]
  (println (:player-name player) ": quer mais carta?")
  (= (read-line) "sim"))

(defn decisionDealerContinue [player-points dealer]
  (let [dealer-points (:points dealer)]
    (if (> player-points 21) false (<= dealer-points player-points))
    ))
