package com.bob.iform.fvm.security;
public enum Permission {
		NONE(0), //无权
		READ(1), //读权限
		WRITE(2), //写权限(隐含具有度权限)
		ALL(3);   //读写权限(和写权限本质一样)
		
		private int value;
		
		Permission(int value){
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
	}