CREATE TABLE planets (
                        planet_id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(50) UNIQUE NOT NULL,
                        type VARCHAR(50),
                        radius_km INT,
                        mass_kg INT,
                        orbital_period_days INT
);

CREATE TABLE moons (
                        moon_id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(50) UNIQUE NOT NULL,
                        diameter_km INT,
                        orbital_period_days INT,
                        planet_id INT,
                        CONSTRAINT fk_planet FOREIGN KEY (planet_id)
                            REFERENCES planets(planet_id)
                            ON DELETE CASCADE
                            ON UPDATE CASCADE
);

CREATE TABLE my_users (
                          user_id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          role VARCHAR(10) NOT NULL,
                          enabled BOOLEAN NOT NULL DEFAULT TRUE,
                          unlocked BOOLEAN NOT NULL DEFAULT TRUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


