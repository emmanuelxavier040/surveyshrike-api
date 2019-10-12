INSERT INTO users(username, password, first_name, last_name) VALUES('user-name1', 'pass', 'First Name', 'Last Name')
INSERT INTO surveys(survey_name, survey_description, creator_name) VALUES ('Survey TEST','This is a test survey','Emmanuel')
INSERT INTO questions(survey_id, order_number, question_text, answer_type) VALUES (1, 1, 'Why do you like cricket?', 'MULTIPLE_LINE_INPUT');

INSERT INTO choices(choice_value, question_id) VALUES ('It is the best',1)
INSERT INTO choices(choice_value, question_id) VALUES ('It is easy to play ',1)
INSERT INTO choices(choice_value, question_id) VALUES ('It is challenging',1)