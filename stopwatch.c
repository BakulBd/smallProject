#include <stdio.h>
#define circle 60

#ifdef _WIN32
#include <conio.h>
#include <windows.h>
#define clrscr() system("cls")  // Clear screen on Windows
#else
#include <unistd.h>
#define clrscr() printf("\033[H\033[J")  // Clear screen on non-Windows platforms
#endif

#ifdef _WIN32
#define sleep(x) Sleep(x * 1000)  // Convert seconds to milliseconds
#else
#define sleep(x) usleep(x * 1000000)  // Convert seconds to microseconds
#endif

int main() {
    int hour, min, second;
    printf("Enter Hour Min Second (hh mm ss):");
    scanf("%d%d%d", &hour, &min, &second);
    clrscr();

    // Check if the entered time values are valid
    if (hour < 0 || hour > 23 || min < 0 || min > 59 || second < 0 || second > 59) {
        printf("Invalid Time");
        return 1;
    }

    int h = 0, m = 0, s = 0;

    // Main loop to simulate the clock and alarm
    while (1) {
        // Display the current time in HH : MM : SS format
        printf("%02d : %02d : %02d", h, m, s);

        // Check if the current time matches the alarm time
        if (h == hour && m == min && s == second) {
            // Clear the screen and display the alarm message
            clrscr();
            printf("ALARM!! %02d : %02d : %02d", h, m, s);
            break;  // Exit the loop when the alarm time is reached
        } else {
            clrscr();  // Clear the screen for the next display
        }

        // Update seconds, minutes, and hours
        s++;
        if (s == circle) {
            m++;
            s = 0;
        }
        if (m == circle) {
            h++;
            m = 0;
        }

        sleep(1);  // Sleep for 1 second before updating the time
    }

    return 0;
}
