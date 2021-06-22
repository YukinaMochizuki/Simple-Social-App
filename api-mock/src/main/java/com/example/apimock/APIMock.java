package com.example.apimock;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
    public class APIMock {

        private List<Comment> createComments(){
            Faker faker = new Faker(new Locale("zh-TW"));
            List<Comment> comments = new ArrayList<>();
            for(int i = 0; i < faker.number().numberBetween(2, 12); i++){
                comments.add(new Comment(faker.name().fullName(), faker.shakespeare().asYouLikeItQuote()));
            }
            return comments;
        }

        @GetMapping("api/posts")
        @CrossOrigin
        public Post[] posts() {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String type = "私人";
            String type2 = "公開";

            String time = "5 分鐘前";
            String time2 = "13 分鐘前";
            String time3 = "26 分鐘前";
            String time4 = "1 小時前";
            String time5 = "3 小時前";

            String location = "社群貼文";
            String location2 = "小屋貼文";

            Faker faker = new Faker(new Locale("zh-TW"));
            List<Post> postList = new ArrayList<>();
            List<Comment> commentList;

            commentList = createComments();
            Post post1 = new Post(faker.name().fullName(), type, time, location, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);
            commentList = createComments();
            Post post2 = new Post(faker.name().fullName(), type2, time2, location2, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);
            commentList = createComments();
            Post post3 = new Post(faker.name().fullName(), type2, time3, location, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);
            commentList = createComments();
            Post post4 = new Post(faker.name().fullName(), type, time4, location2, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);
            commentList = createComments();
            Post post5 = new Post(faker.name().fullName(), type, time4, location, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);
            commentList = createComments();
            Post post6 = new Post(faker.name().fullName(), type2, time5, location2, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);
            commentList = createComments();
            Post post7 = new Post(faker.name().fullName(), type, time5, location2, faker.lorem().paragraph(), faker.number().randomDigit(), commentList.size(), commentList);

            postList.add(post1);
            postList.add(post2);
            postList.add(post3);
            postList.add(post4);
            postList.add(post5);
            postList.add(post6);
            postList.add(post7);

            return postList.toArray(new Post[0]);
    }


        @GetMapping("api/messages")
        public String messages() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "[\n" +
                    "  {\n" +
                    "    \"name\": \"小華\",\n" +
                    "    \"content\": \"出來打球阿，你當球\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"小嘉\",\n" +
                    "    \"content\": \"現在都不能出門，3+11 謝摟:)))\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"小明\",\n" +
                    "    \"content\": \"為什麼每次小美都說要去洗澡QQ\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"小美\",\n" +
                    "    \"content\": \"小明好煩= =\"\n" +
                    "  }\n" +
                    "]";
        }
}
