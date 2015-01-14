(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn- word-distance [w1 w2]
  (- (max (count w1) (count w2))
     (count (filter identity (map = w1 w2)))))

(defn- single-distance? [w other]
  (= (word-distance w other) 1))

(defn- expand [dict path]
  (let [word (last path)
        seen (into #{} path)]
    (->> dict
         (remove seen)
         (filter (partial single-distance? word))
         (map (partial conj path)))))

(defn- expansions [dict word]
  (tree-seq (constantly true)
            (partial expand dict)
            [word]))

(defn doublets [from target]
  (let [matches (filter #(= target (last %)) (expansions words from))]
    (if-let [shortest (first (sort-by count matches))]
      shortest
      [])))
