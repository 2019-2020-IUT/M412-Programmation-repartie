/**
 *  ----------------------------------------------------------------------------
 * |                        	PingPongRunnable.java							|
 * |                                                                            |
 * | @author     JunkJumper (Josée SRIFI) 										|
 * | @since      21/01/2020                                						|
 *  ----------------------------------------------------------------------------
 * 
 */

package td1.threads;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class PingPongRunnable extends Thread {

	/* ATTRIBUTS */
	
	private String nom;
	private int nb;
	
	/* CONSTRUCTEURS */
	
	public PingPongRunnable() {
		this("DefaultTreadName", 0);
	}
	
	public PingPongRunnable(String n) {
		this(n, 0);
	}
	
	public PingPongRunnable(int nb) {
		this("DefaultTreadName", nb);
	}
	
	public PingPongRunnable(String n, int nb) {
		this.nom = n;
		this.nb = nb;
	}
	
	/* METHODES */
	
	public void run() {
		for (int i = 0; i < this.nb; i++) {
					try {
			sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println(this.nom + " - " + i);
		}
	}

	public static void main(String args[]) {
		(new Thread(new PingPongRunnable("Ping", 20))).start();
		(new Thread(new PingPongRunnable("Pong", 20))).start();
	}


	/* GETTERS & SETTERS */
	
		/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the nb
	 */
	public int getNb() {
		return nb;
	}

	/**
	 * @param nb the nb to set
	 */
	public void setNb(int nb) {
		this.nb = nb;
	}
	
}