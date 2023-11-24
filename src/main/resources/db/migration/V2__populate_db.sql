INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('John Петров', '1990-05-15', 'Trainee', 800),
    ('Jane Smith', '1985-09-20', 'Junior', 1200),
    ('David Johnson', '1980-03-10', 'Middle', 2500),
    ('Emily Brown', '1975-12-05', 'Senior', 5000),
    ('Michael Wilson', '1992-08-30', 'Trainee', 900),
    ('Linda Lee', '1987-04-25', 'Junior', 1100),
    ('Christopher Davis', '1978-11-12', 'Middle', 2600),
    ('Sarah Miller', '1973-07-18', 'Senior', 5200),
    ('Robert Taylor', '1989-01-02', 'Trainee', 950),
    ('Jennifer Anderson', '1984-06-08', 'Junior', 1300);

INSERT INTO client (NAME)
VALUES
    ('privatBank'),
    ('pumbBank'),
    ('a-bank'),
    ('sens-bank'),
    ('ochad-bank');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (1, '2023-01-01', '2023-06-30'),
    (2, '2023-02-15', '2023-05-15'),
    (3, '2023-03-10', '2023-07-31'),
    (4, '2023-04-20', '2023-06-20'),
    (5, '2023-05-05', '2023-08-31'),
    (1, '2023-06-01', '2023-12-31'),
    (3, '2023-07-15', '2023-09-30'),
    (2, '2023-08-10', '2023-11-30'),
    (4, '2023-09-05', '2023-12-05'),
    (5, '2023-10-20', '2024-01-20');
