package io.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/*
 * Business service are mostly singleton and an instance of the class is created by spring.
 * Any controller or service can request spring boot "Hey springboot, i want this service", and 
 * spring boot responds to it
 */

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("SpringBoot", "SpringBoot Frameword", "SpringBoot Framework Description"),
			new Topic("Spring", "Spring Frameword", "Spring Framework Description"),
			new Topic("Java", "Java Frameword", "Java Framework Description")
		));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		for(Topic t:topics) {
			if(t.getId().equals(id)) return t;
		}
		return null;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t-> t.getId().equals(id));
	}
	
	
}
