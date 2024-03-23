import matplotlib.pyplot as plt

# Read the contents of the file and split it into lines
with open("time_analyses.txt", "r") as file:
    lines = file.readlines()

# Calculate the number of lines to consider (20% of total lines)
num_lines_to_consider = int(1 * len(lines))

# Initialize dictionaries to store data for each thread
data = {}
for line in lines[:num_lines_to_consider]:
    if line.startswith("T"):
        thread_name = line.strip()
        data[thread_name] = {"occurrences": [], "time": []}

# Parse the lines and extract data for each thread
for i in range(len(lines)):
    if lines[i].startswith("T"):
        thread_name = lines[i].strip()
        for j in range(i + 1, len(lines)):
            if not lines[j].startswith("T"):
                data[thread_name]["occurrences"].append(len(data[thread_name]["occurrences"]) + 1)
                data[thread_name]["time"].append(float(lines[j]))

# Plot data for each thread as a curved line
plt.figure(figsize=(10, 6))
for thread_name, thread_data in data.items():
    plt.plot(thread_data["time"], thread_data["occurrences"], label=thread_name, marker='o')

# Add labels and legend
plt.xlabel("Time")
plt.ylabel("Occurrences")
plt.title("Thread Time Analysis (100% of data)")
plt.legend(title="Threads", bbox_to_anchor=(1.05, 1), loc='upper left')
plt.grid(True)

# Show plot
plt.show()
