INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (1, 'Brice', 'Argenson', 'bargenson@edgenda.com');
INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (2, 'Gregoire', 'Weber', 'gweber@cleverage.com');
INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (3, 'John', 'Doe', 'jdoe@bnc.com');

INSERT INTO EVENT(ID, NAME, DESCRIPTION, START_DATE, END_DATE, LOCATION) VALUES (1, 'DevOps Training', 'Training for NBC about DevOps principles and tools. ', '2019-05-07T08:15', '2019-05-09T12:30', '500 rue Saint-Jacques, Edifice Toronto Dominion');
INSERT INTO EVENT(ID, NAME, DESCRIPTION, START_DATE, END_DATE, LOCATION) VALUES (2, 'GCP Training ', 'Training for NBC about GCP Architecture  ', '2019-05-20T08:15', '2008-05-23T12:30', '500 rue Saint-Jacques, Edifice Toronto Dominion');


INSERT INTO INVITATION(ID, EVENT_ID, GUEST_ID, STATE) VALUES (3, 1, 1, 0);
