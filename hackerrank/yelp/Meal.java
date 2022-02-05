package practice.yelp.hackerrank;// <-- EXPAND to see the data classes

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Meal {
    String name;
    List<String> ingredients;

    public Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }
}

class Solution {

    public static int getUniqueMealCount(List<Meal> meals) {
        Set<Set<String>> data = new HashSet<>();
        for (Meal meal : meals) {
            data.add(new HashSet<>(meal.getIngredients()));
        }
        return data.size();
    }


    public static void main(String[] args) {
        String line;
        List<Meal> meals = new ArrayList<Meal>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/dev/sandbox/job-hunting/yelp/input_custom.txt")));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                meals.add(
                        new Meal(
                                parts[0],
                                Arrays.asList(parts[1].split(","))
                        )
                );
            }

            int uniqueMeals = getUniqueMealCount(meals);
            System.out.println(uniqueMeals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
