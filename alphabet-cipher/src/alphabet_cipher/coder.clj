(ns alphabet-cipher.coder)

(def alphabet (map char (range 97 123)))
(defn- alphabet-map [coll] (zipmap alphabet coll))

(defn- tabula-recta-row [chr]
  (alphabet-map
    (take (count alphabet) (drop-while (complement #{chr}) (cycle alphabet)))))

(def tabula-recta (alphabet-map (map tabula-recta-row alphabet)))

(defn- alphabet-cipher [f secret message]
  (apply str (map f message (cycle secret))))

(defn- lookup [row col]
  (get-in tabula-recta [row col]))

(defn- reverse-lookup [chr row-key]
  (let [row (tabula-recta row-key)]
    (some #(if (#{chr} (row %)) %) (keys row))))

(def encode (partial alphabet-cipher lookup))
(def decode (partial alphabet-cipher reverse-lookup))
