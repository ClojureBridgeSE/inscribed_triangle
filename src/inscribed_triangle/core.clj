(ns drawing.lines
  (:require [quil.core :as q]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (q/stroke 255 0 0))

(defn inscribed-points [[x y] r]
  (map (fn [i]
         (let [a (* (/ i 3) (* Math/PI 2))]
           [(+ x (* (Math/sin a) r))
            (- y (* (Math/cos a) r))]))
       (range 3)))

(defn draw []
  (let [r (q/mouse-x)
        d (* r 2)
        center [250 250]]
    (q/fill 0 0 0)
    (apply q/ellipse (flatten [center d d]))
    (q/fill 255 255 255)
    (apply q/triangle (flatten (inscribed-points center r)))))

(q/defsketch hello-lines
  :title "You can see lines"
  :size [500 500]
  :setup setup
  :draw draw
  :features [:keep-on-top])
