package com.minitennis;

import java.awt.Graphics2D;

public class Ball {
	//Posizione corrente della pallina
    int x = 0;
    int y = 0;

    //Velocità della pallina: se R=xa=1 L=xa=-1 D=ya=1 U=ya=-1
    int xa = 1;
	int ya = 1;
    
	private App game;

	public Ball(App game) {
		this.game = game;
	}

	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - 30)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - 30)
			ya = -1;

		x = x + xa;
		y = y + ya;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}
}