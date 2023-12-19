(ns Rules)

(defn convertJQKTo10 [card]
  (if (> card 10) 10 card))

(defn cardATo11 [card]
  (if (= card 1) 11 card))

(defn contCards [cards]
  (let [cards-JQK (map convertJQKTo10 cards)
        cards-ATo-11 (map cardATo11 cards-JQK)
        count-with-A1 (reduce + cards-JQK)
        count-with-A11 (reduce + cards-ATo-11)]
    (if (> count-with-A11 21)  count-with-A1 count-with-A11)))
