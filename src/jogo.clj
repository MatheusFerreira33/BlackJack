(ns jogo
  (:require [card-ascii-art.core :as card]
            [Cards :as Cards]
            [Players :as Players]))


(defn ask [player fun-decison-continue]
  (if (fun-decison-continue player)
    (let [player-with-MoreCard (Cards/more-card player)]
      (card/print-player player-with-MoreCard)
      (recur player-with-MoreCard fun-decison-continue))
    player))

(defn resultGame [player dealer]
  (let [playerPoints (:points player)
        dealerPoints (:points dealer)
        playerName (:player-name player)
        dealerName (:player-name dealer)
        messageResult    (cond
                           (and (> playerPoints 21) (> dealerPoints 21)) "Ambos perderam"
                           (= playerPoints dealerPoints) "Empatou"
                           (> playerPoints 21) (str dealerName " Ganhou")
                           (> dealerPoints 21) (str playerName " Ganhou")
                           (> playerPoints dealerPoints) (str playerName " Ganhou")
                           (> dealerPoints playerPoints) (str dealerName " Ganhou"))]
    (card/print-player player)
    (card/print-player dealer)
    (println messageResult)
    ))

(def player-1 (Players/player "Matheus Ferreira"))
(card/print-player player-1)

(def dealer (Players/player "Dealer"))
(card/print-masked-player dealer)

(def player-after (ask player-1 Players/decisionContinuePlayer))
(def partialDealerDecisionContinue  (partial Players/decisionDealerContinue (:points player-after)))
(def dealer-after (ask dealer partialDealerDecisionContinue))

(resultGame player-after dealer-after)
