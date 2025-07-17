CREATE TABLE project (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         date_created DATE NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE task (
                      id           INTEGER      NOT NULL AUTO_INCREMENT,
                      name         VARCHAR(255) NOT NULL,
                      description  TEXT,
                      date_created DATE         NOT NULL,
                      due_date     DATE,
                      status       VARCHAR(50)  NOT NULL DEFAULT 'TO_DO',
                      project_id   INTEGER,
                      PRIMARY KEY (id),
                      FOREIGN KEY (project_id) REFERENCES project(id)
);
