#include <GL/freeglut.h>
#include <stdlib.h>
/* Keyboard callback function */
void keyboard(unsigned char key, int x, int y)
{
  switch (key)
  {
    /* Exit on escape key press */
    case '\x1B':
    {
      exit(EXIT_SUCCESS);
      break;
    }
  }
}

/* Display callback function */
float angle = 0.0f;

void display()
{
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

  //reset transformations
  glLoadIdentity();
  
  //set the camera
  gluLookAt(0.0f, 0.0f, 5.0f,
		   0.0f, 0.0f, 0.0f,
		   0.0f, 1.0f, 0.0f);
  
  glRotatef(angle, 0.0f, 1.0f, 0.0f);
  
  
  /* Display a green pentagon */
  glColor3f(0.0f, 1.0f, 0.0f);

  glBegin(GL_POLYGON);
    glVertex3f( 0.75f, -0.5f,0);
    glVertex3f( 0.75f,  0.5f,0.4f);
    glVertex3f(-0.25f,  0.75f,0.3f);
	glVertex3f(-0.75f, 0,0.5);
	glVertex3f(-0.25f,  -0.75f,0.2);
  glEnd();
  
  angle +=1;
  glutSwapBuffers(); //back buffer becomes front and front buffer becomes back;
}

void reshape(int w,int h)
{
	//prevent a divide by zero
	if (h==0)
			h=1;
	float ratio=w* 1.0/h;
	//select a certain matrix and reset it
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	
	//set viewport(relative to the entire window,the parameters are the bottom corners and the width and height)
	glViewport(0, 0, w, h);
	
	//Set perspective
	gluPerspective(45,ratio,1,1000);
	
	//Getback to the modelview
	glMatrixMode(GL_MODELVIEW);
	
}

int main(int argc,char **argv)
{
  glutInit(&argc,argv);

  /* Create a single window with a keyboard and display callback */
  glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGBA); //not the double buffer used for animation(back buffer draws and front buffer shows)
  glutInitWindowPosition(100,100);
  glutInitWindowSize(600,600);
  glutCreateWindow("GLUT Test");
  //register callbacks
  glutKeyboardFunc(keyboard);
  glutDisplayFunc(display);
  glutReshapeFunc(reshape);
  glutIdleFunc(display);
  /* Run the GLUT event loop */
  glutMainLoop();

  return EXIT_SUCCESS;
}