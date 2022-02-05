package test.businesssimilarity;// <-- EXPAND to see the data classes

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PositiveReview {
    Integer userId;
    Integer businessId;

    public PositiveReview(Integer userId, Integer businessId) {
        this.userId = userId;
        this.businessId = businessId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getBusinessId() {
        return this.businessId;
    }
}

class Solution {

    /*
    Sample Input
        {
            "businessOfInterestId": 10,
            "positiveReviews": [
                PositiveReview(
                    "userId": 1,
                    "businessId": 10
                ),
                PositiveReview(
                    "userId": 2,
                    "businessId": 10
                ),
                PositiveReview(
                    "userId": 1,
                    "businessId": 11
                ),
                PositiveReview(
                    "userId": 2,
                    "businessId": 11
                ),
                PositiveReview(
                    "userId": 1,
                    "businessId": 12
                ),
                PositiveReview(
                    "userId": 2,
                    "businessId": 12
                ),
                PositiveReview(
                    "userId": 3,
                    "businessId": 12
                )
            ]
        }
    Sample Output
        11
    Business Similarity Score against business 10:
        11: 2 / (2 + 2 - 2) = 1.0
        12: 2 / (2 + 3 - 2) = 0.667
    */
    public static Integer findMostSimilarBusiness(
            Integer businessOfInterestId,
            List<PositiveReview> positiveReviews
    ) {
        Map<Integer, Double> similarities = new HashMap<>();
        Map<Integer, Set<Integer>> businessIdToUniqueUserIds = positiveReviews
                .stream()
                .collect(Collectors.groupingBy(PositiveReview::getBusinessId, Collectors.mapping(PositiveReview::getUserId, Collectors.toSet())));
        Set<Integer> userIdsInterest = businessIdToUniqueUserIds.get(businessOfInterestId);
        for (Integer businessId : businessIdToUniqueUserIds.keySet()) {
            if (!businessId.equals(businessOfInterestId)) {
                Set<Integer> userIdsCandidate = businessIdToUniqueUserIds.get(businessId);
                Set<Integer> intersect = userIdsInterest.stream().filter(userIdsCandidate::contains).collect(Collectors.toSet());
                Set<Integer> union = Stream.concat(userIdsInterest.stream(), userIdsCandidate.stream()).collect(Collectors.toSet());
                double similarity = 1.0 * intersect.size() / union.size();
                similarities.put(businessId, similarity);
            }
        }
        return Collections.max(similarities.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String jsonString = "";
            String line;
            while ((line = br.readLine()) != null) {
                jsonString = jsonString + line;
            }

            JSONObject json = (JSONObject) new JSONParser().parse(jsonString);

            Integer businessOfInterestId = ((Long) json.get("business_of_interest_id")).intValue();

            JSONArray positiveReviewsJSON = (JSONArray) json.get("positive_reviews");

            Iterator<?> positiveReviewsIterator = positiveReviewsJSON.iterator();

            List<PositiveReview> positiveReviews = new ArrayList<PositiveReview>();
            while (positiveReviewsIterator.hasNext()) {
                JSONObject review = (JSONObject) positiveReviewsIterator.next();
                positiveReviews.add(new PositiveReview(
                        ((Long) review.get("user_id")).intValue(),
                        ((Long) review.get("business_id")).intValue()
                ));
            }

            Integer mostSimilarBusiness = findMostSimilarBusiness(
                    businessOfInterestId,
                    positiveReviews
            );

            System.out.println(mostSimilarBusiness.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
