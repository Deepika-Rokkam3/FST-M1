# Using Selenium:

# Open the training support site. (https://training-support.net)

# Print the title of the page

# Click the about us button

# Print the title of the new page

from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/")

    print("page title is:"+ driver.Title)

    driver.find_element(By.LINK_TEXT, "About US")

    print("new page title is:" + driver.title)



