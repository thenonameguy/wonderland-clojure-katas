(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(defn river-crossing-plan []
  [[[:fox :goose :corn :you] [:boat] []]
   [[:fox :corn] [:boat :you :goose] []]
   [[:fox :corn] [:boat] [:goose :you]]
   [[:fox :corn] [:boat :you] [:goose]]
   [[:fox :corn :you] [:boat] [:goose]]
   [[:fox] [:corn :boat :you] [:goose]]
   [[:fox] [:boat] [:goose :you :corn]]
   [[:fox] [:boat :you :goose] [:corn]]
   [[:fox :goose :you] [:boat] [:corn]]
   [[:goose] [:boat :you :fox] [:corn]]
   [[:goose] [:boat] [:corn :you :fox]]
   [[:goose] [:boat :you] [:corn :fox]]
   [[:goose :you] [:boat] [:corn :fox]]
   [[] [:boat :you :goose] [:corn :fox]]
   [[] [:boat] [:corn :fox :goose :you]]])
