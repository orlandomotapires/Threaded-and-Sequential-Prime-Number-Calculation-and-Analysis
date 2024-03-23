import matplotlib.pyplot as plt

# List to store data from the file
data = []

# Open the file and read the values
with open('./txt_files/time_analyses.txt', 'r') as file:
    for line in file:
        # Split the line into values
        values = line.split()
        # Convert the values to the appropriate types
        color = int(values[0])
        y = float(values[1])
        x = int(values[2])
        # Add the values to the data list
        data.append((color, y, x))

# Initialize variables to track line changes
current_color = None
x_values = {}
y_values = {}

# Iterate over the data and plot each point
for entry in data:
    color, y, x = entry
    if color not in x_values:
        x_values[color] = []
        y_values[color] = []
    x_values[color].append(x)
    y_values[color].append(y)

# Plot continuous lines for each color
for color in x_values:
    if color == 1:
        plt.plot(x_values[color], y_values[color], label=f'{color} Thread(s)', color='red', linestyle='-')
    elif color == 5:
        plt.plot(x_values[color], y_values[color], label=f'{color} Thread(s)', color='blue', linestyle='-')
    elif color == 10:
        plt.plot(x_values[color], y_values[color], label=f'{color} Thread(s)', color='green', linestyle='-')

# Add labels and legend
plt.xlabel('Percentage of data')
plt.ylabel('Time of execution')
plt.title('Data Result')
plt.legend(title='Number of threads', bbox_to_anchor=(0, 1), loc='upper left')  # Position adjusted to the upper left

# Save the plot as an image
plt.grid(True)
plt.savefig('./assets/Data_results.png', bbox_inches='tight')
plt.show()
