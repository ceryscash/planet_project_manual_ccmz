INSERT INTO planets (name, type, radius_km, mass_kg, orbital_period_days)
VALUES
    ('Mercury', 'Terrestrial', 2440, 33011, 88),
    ('Venus',   'Terrestrial', 6052, 48675, 225),
    ('Earth',   'Terrestrial', 6371, 59722, 365),
    ('Mars',    'Terrestrial', 3390, 64171, 687),
    ('Jupiter', 'Gas Giant',  69911, 18982, 4333);

INSERT INTO moons (name, diameter_km, orbital_period_days, planet_id)
VALUES
    ('Moon',     3474, 27.3, 3),
    ('Phobos',     22, 0.32, 4),
    ('Deimos',     12, 1.26, 4),
    ('Io',       3643, 1.77, 5),
    ('Europa',   3122, 3.55, 5),
    ('Ganymede', 5268, 7.15, 5),
    ('Callisto', 4821, 16.69, 5);

INSERT INTO my_users(username, password, enabled, unlocked, role)
VALUES
    ('admin', '$2a$10$6eGM9GyhH3x0vfghntn4cuVeZlA2oUfJfsIs7eFsV5uGApK.XdSF6', true, true, 'ADMIN'),
    ('student', '$2a$10$6eGM9GyhH3x0vfghntn4cuVeZlA2oUfJfsIs7eFsV5uGApK.XdSF6', true, true, 'STUDENT'),
    ('staff', '$2a$10$6eGM9GyhH3x0vfghntn4cuVeZlA2oUfJfsIs7eFsV5uGApK.XdSF6', true, true, 'STAFF'),
    ('locked', '$2a$10$6eGM9GyhH3x0vfghntn4cuVeZlA2oUfJfsIs7eFsV5uGApK.XdSF6', true, false, 'STUDENT'),
    ('disabled', '$2a$10$6eGM9GyhH3x0vfghntn4cuVeZlA2oUfJfsIs7eFsV5uGApK.XdSF6', false, true, 'STAFF');
