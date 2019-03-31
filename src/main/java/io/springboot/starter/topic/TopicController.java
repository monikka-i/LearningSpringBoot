package io.springboot.starter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * Spring MVC is another project inside spring framework which maps requests to responses
 */
@RestController
public class TopicController {
    // Resources (or) Entity : Topic, Course, Lesson
	/*
	 * GET /topics       -> gets all topics
	 * GET /topics/id    -> gets the topic
	 * POST /topics      -> creates a new topic
	 * PUT /topics/id    -> Updates the topic
	 * DELETE /topics/id -> deletes the topic
	 */
	
	@Autowired // to declare dependency for controller, where dependency injection takes place
	private TopicService topicservice;
	
	/*Spring mvc responds in the form of json objects since it detected a REST Controller*/
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		/*return Arrays.asList(
			new Topic("SpringBoot", "SpringBoot Frameword", "SpringBoot Framework Description"),
			new Topic("Spring", "Spring Frameword", "Spring Framework Description"),
			new Topic("Java", "Java Frameword", "Java Framework Description")
		);*/
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicservice.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicservice.deleteTopic(id);
	}
	
}
