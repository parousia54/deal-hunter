package com.pinkdroid.dealshunter.model;

import java.util.ArrayList;

public class Review {
	public int bbId;
	public String aboutId;
	public String latestComment;
	public String commenter;
	public String commentDate;
	public String starts;
	public float distance;

	public static ArrayList<Review> reviews = new ArrayList<Review>();
	static {
		reviews.add(new Review(
				4,
				"17d138e66a886d558dd3d7f873ee5de3c4e237b550ececf61690f640d87e7b70",
				"Things look good from the outside of Mai Thai. The colours are attractive, especially when the sun goes down and the purple lights come on. There is something about colours that seem to enrich your dining experience, I'm sure there's a study about it. But whatever the lights do here seem to make the meals fantastic.",
				"Jason H.", "1/11/2011", "4", 6.5f));
		reviews.add(new Review(
				0,
				"e082adc124cb7cd7bf49d8390947a7c0dac76726af82383aa1745a6f9b205cd5",
				"Went for a colour - Geoff was great, mixed a fabulous red for me & was friendly and keen for a chat. Unfortunately a different staff member washed my hair and there was lots of wincing at the hair pulling and rough treatment. A third staff member did the blow dry, which looked good but again lots of pulling and ouchies in my follicles. I'll definitely be back, but I'll ask for Geoff to do the blow dry too.",
				"Hannah O.", "25/7/2012", "4", 7f));
		reviews.add(new Review(1, null, null, null, null, null, 1.4f));
		reviews.add(new Review(2, null, null, null, null, null, 2.2f));
		reviews.add(new Review(
				3,
				"4d633ed62ec7a39d4a265063af63baf3b70e6dd7ddbd6e5ec1a2d66c7f5fcf2f",
				"Hoyts Melbourne Central is conveniently located - Grill'd and the Groove Train are next door and Nandos is right across. For those after pre-movie drinks, the Lion's hotel or Cho Gao bar won't dissapoint + you've got the train station on the lower ground and plenty of parking as well. Tickets are pricey for sure and, now that all movie makers are jumping on the 3D train at the first chance they get, you'll really feel a sting when buying a ticket.",
				"Kevin S.", "30/1/2012", "4", 1.7f));
	}

	public Review(int bbId, String aboutId, String latestComment, String commenter, String commentDate, String starts, float distance) {
		super();
		this.aboutId = aboutId;
		this.latestComment = latestComment;
		this.commenter = commenter;
		this.commentDate = commentDate;
		this.starts = starts;
		this.distance = distance;
	}

}
