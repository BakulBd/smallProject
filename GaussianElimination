#include <stdio.h>
#define MAX_SIZE 20


void swap(float *a, float *b)
 {
    float temp = *a;
    *a = *b;
    *b = temp;
}

void gaussianElimination(float A[MAX_SIZE][MAX_SIZE + 1], int n) 
{
    int i, j, k;
    for (i = 0; i < n; i++) 
        {
        int pivot_row = i;
        for (j = i + 1; j < n; j++) 
        {
            if (A[j][i] > A[pivot_row][i])
                pivot_row = j;
        }
        for (k = i; k <= n; k++) 
        {
            swap(&A[i][k], &A[pivot_row][k]);
        }
        for (j = i + 1; j < n; j++) 
        {
            float f = A[j][i] / A[i][i];
            for (k = i; k <= n; k++) {
                A[j][k] -= f * A[i][k];
            }
        }
    }
}

int main() 
{
    int i, j, n;
    float A[MAX_SIZE][MAX_SIZE + 1];
    printf("Enter the order of the matrix: ");
    scanf("%d", &n);
    printf("Enter the elements of the augmented matrix row-wise:\n");
    for (i = 0; i < n; i++) {
        printf("Row %d:\n", i + 1);
        for (j = 0; j <= n; j++) {
            printf("A[%d][%d] : ", i + 1, j + 1);
            scanf("%f", &A[i][j]);
        }
    }

    gaussianElimination(A, n);
    
    //Bokul

    int inconsistent = 0;
    if (A[n - 1][n - 1] == 0 && A[n - 1][n] != 0)
    {
        inconsistent = 1;
    }

    if (inconsistent)
    {
        printf("\nThe system is inconsistent. It has no solution.\n");
    } else {
        float x[MAX_SIZE];
        for (i = n - 1; i >= 0; i--) 
        {
            x[i] = A[i][n];
            for (j = i + 1; j < n; j++) {
                x[i] -= A[i][j] * x[j];
            }
            x[i] /= A[i][i];
        }


        printf("\nThe solution is: \n");
        for (i = 0; i < n; i++) 
        {
            printf("x%d = %.3f\n", i + 1, x[i]);
        }
    }

    return 0;
}
