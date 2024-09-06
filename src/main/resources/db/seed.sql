use qwizdb;
insert into category (category_id, category_name) values (1,'category1');
insert into category (category_id, category_name) values (2,'category2');
insert into category (category_id, category_name) values (3,'category3');

insert into leaderboard (leaderboard_id, quizzes_guessed, total_score) values (1,4,20);
insert into leaderboard (leaderboard_id, quizzes_guessed, total_score) values (2,5,22);
insert into leaderboard (leaderboard_id, quizzes_guessed, total_score) values (3,8,23);
insert into leaderboard (leaderboard_id, quizzes_guessed, total_score) values (4,12,44);

insert into user (user_id, email, picture_url, role, username, leaderboard_id) values(1,'example1@gmail.com','','user','player1',1);
insert into user (user_id, email, picture_url, role, username, leaderboard_id) values(2,'example2@yahoo.com','','user','player1',2);
insert into user (user_id, email, picture_url, role, username, leaderboard_id) values(3,'example3@inbox.com','','user','player1',3);
insert into user (user_id, email, picture_url, role, username, leaderboard_id) values(4,'example4@gmail.com','','user','player1',4);

insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(1,'quiz1','answer1',2,'2012-12-23',1,1);
insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(2,'quiz2','answer2',2,'2013-12-23',1,1);
insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(3,'quiz3','answer3',3,'2014-12-23',3,2);
insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(4,'quiz4','answer4',3,'2012-12-23',2,1);
insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(5,'quiz5','answer5',4,'2014-12-23',3,3);
insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(6,'quiz6','answer6',4,'2015-12-23',4,3);
insert into quiz(quiz_id, title, answer, point_value, created_at, user_id, category_id) values(7,'quiz7','answer7',5,'2018-12-23',4,2);

insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(1,2,'2023-02-03',1,2);
insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(2,2,'2023-03-03',2,4);
insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(3,2,'2023-04-03',3,3);
insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(4,2,'2023-05-03',4,2);
insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(5,2,'2023-06-03',5,2);
insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(6,2,'2023-07-03',6,1);
insert into quiz_result(quiz_result_id, score, guess_date, quiz_id, user_id) values(7,2,'2023-08-03',7,1);
