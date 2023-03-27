package Model;

public class ModelTicToe {
	private int level_value; /// lưu giá TRỊ ĐỘ KHÓ tương ứng 0,1,2
	public int go_first_value ; // máy đi trước tr là 0, người đi trước 1
	public int [] matrix_tic_toe [];     // lưu thông thông tin ma trận hiện tại 
	
	public ModelTicToe() {
		go_first_value =1;
		level_value = 0;   // khởi tạo giá trị độ khó 
		matrix_tic_toe = new int[3][3]; // khởi tạo ma trận 
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				matrix_tic_toe[i][j] = 0;
			}
		}
//		matrix_tic_toe[0][0]=0;
//		matrix_tic_toe[0][1]=0;
//		matrix_tic_toe[0][2]=0;
//		matrix_tic_toe[1][0]=0;
//		matrix_tic_toe[1][1]=0;
//		matrix_tic_toe[1][2]=0;
//		matrix_tic_toe[2][0]=0;
//		matrix_tic_toe[2][1]=0;
//		matrix_tic_toe[2][2]=0;
	}

	public int getLevel_value() {
		return level_value;
	}

	public void setLevel_value(int level_value) {
		this.level_value = level_value;
	}
	public boolean check_matrix_empty() { // kiểm tra ma trận đầy
		int sum = 0;
		sum = matrix_tic_toe[0][0]*matrix_tic_toe[0][1]*matrix_tic_toe[0][2]*matrix_tic_toe[1][0]*matrix_tic_toe[1][1]*matrix_tic_toe[1][2]*matrix_tic_toe[2][0]*matrix_tic_toe[2][1]*matrix_tic_toe[2][2];
		if (sum==0) return true ;
		else return false ;
	}
	public static int random(int a,int b) {  // sinh ra một số ngẫu nhiên từ a, b
		double x = Math.random(); 
		int xx = a;
		xx = xx + (int)(x*(b-a+1));
		return xx;
	}
	public void random_generate() {   // chế độ chơi dễ , con ai . đánh đại , 0 ch danh, 1 la ng, 2 la AI
		int x=random(0,2),y=random(0,2);
		if (check_matrix_empty()==true) {
			x=random(0,2);
			y=random(0,2);
			while (matrix_tic_toe[x][y]!=0) {
				x=random(0,2);
				y=random(0,2);
			}
			matrix_tic_toe[x][y]=2;
		}
		
	}
	public void god_generate() {
		int count_zero = 0,remember_i = 0,remember_j = 0,sum=0;
		if (check_matrix_empty()==true) {
			int x=1;
			int y=1;
			int i,j;
			///////////////   chong thua
			for (i=0;i<3;i++) {
				sum =0 ;
				count_zero = 0;
				for (j=0;j<3;j++) {
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==2) {
					x=remember_i;
					y=remember_j;
					break;
				}
				
			}
			for (j=0;j<3;j++) {
				sum =0 ;
				count_zero = 0;
				for (i=0;i<3;i++) {
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==2) {
					x=remember_i;
					y=remember_j;
					break;
				}
			}
			if (matrix_tic_toe[0][0]==0 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][2]==1) {
				x=0;
				y=0;
			} else if (matrix_tic_toe[0][0]==1 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][2]==1) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][0]==1 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][2]==0) {
				x=2;
				y=2;
			} 
			if (matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][0]==1) {
				x=0;
				y=2;
			} else if (matrix_tic_toe[0][2]==1 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][0]==1) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][2]==1 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][0]==0) {
				x=2;
				y=0;
			} 
			//////////////////  thang
			for (i=0;i<3;i++) {
				sum =0 ;
				count_zero = 0;
				for (j=0;j<3;j++) {
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==4) {
					x=remember_i;
					y=remember_j;
					break;
				}
				
			}
			for (j=0;j<3;j++) {
				sum =0 ;
				count_zero = 0;
				for (i=0;i<3;i++) {
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==4) {
					x=remember_i;
					y=remember_j;
					break;
				}
			}
			if (matrix_tic_toe[0][0]==0 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][2]==2) {
				x=0;
				y=0;
			} else if (matrix_tic_toe[0][0]==2 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][2]==2) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][0]==2 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][2]==0) {
				x=2;
				y=2;
			} 
			if (matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][0]==2) {
				x=0;
				y=2;
			} else if (matrix_tic_toe[0][2]==2 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][0]==2) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][2]==2 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][0]==0) {
				x=2;
				y=0;
			} 
			////////////////// anti duong cheo 
			if (matrix_tic_toe[1][1]==1 && matrix_tic_toe[0][0]==0 && matrix_tic_toe[0][1]==0 && matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][0]==0 && matrix_tic_toe[1][2]==0 && matrix_tic_toe[2][0]==0 && matrix_tic_toe[2][1]==0 && matrix_tic_toe[2][2]==0 ) {
				int duongcheo =0, ocheo=0;
				ocheo = matrix_tic_toe[0][0]*matrix_tic_toe[2][2]*matrix_tic_toe[0][2]*matrix_tic_toe[2][0];
				if (ocheo==0) {
					while (true) {
						duongcheo = random(1,4);
						if (duongcheo==1 && matrix_tic_toe[0][0]==0 ) {
							x=0;
							y=0;
							break;
						} else if (duongcheo==2 && matrix_tic_toe[2][2]==0) {
							x=2;
							y=2;
							break;
						} else if (duongcheo==3 && matrix_tic_toe[0][2]==0) {
							x=0;
							y=2;
							break;
						} else if (duongcheo==4 && matrix_tic_toe[2][0]==0) {
							x=2;
							y=0;
							break;
						}
					}
				}
			}
			//////////////////// anti - duong cheo 2
			if (matrix_tic_toe[1][1]==1 && matrix_tic_toe[0][0]==1 && matrix_tic_toe[0][1]==0 && matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][0]==0 && matrix_tic_toe[1][2]==0 && matrix_tic_toe[2][0]==0 && matrix_tic_toe[2][1]==0 && matrix_tic_toe[2][2]==2 ) {
				int duongcheo=0;
				while (true) {
					duongcheo = random(1,2);
					if (duongcheo==1 && matrix_tic_toe[0][2]==0 ) {
						x=0;
						y=2;
						break;
					} else if (duongcheo==2 && matrix_tic_toe[2][0]==0) {
						x=2;
						y=0;
						break;
					} 
				}
			}//
			if (matrix_tic_toe[1][1]==1 && matrix_tic_toe[0][0]==2 && matrix_tic_toe[0][1]==0 && matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][0]==0 && matrix_tic_toe[1][2]==0 && matrix_tic_toe[2][0]==0 && matrix_tic_toe[2][1]==0 && matrix_tic_toe[2][2]==1 ) {
				int duongcheo=0;
				while (true) {
					duongcheo = random(1,2);
					if (duongcheo==1 && matrix_tic_toe[0][2]==0 ) {
						x=0;
						y=2;
						break;
					} else if (duongcheo==2 && matrix_tic_toe[2][0]==0) {
						x=2;
						y=0;
						break;
					} 
				}
			}
			if (matrix_tic_toe[1][1]==1 && matrix_tic_toe[0][0]==0 && matrix_tic_toe[0][1]==0 && matrix_tic_toe[0][2]==1 && matrix_tic_toe[1][0]==0 && matrix_tic_toe[1][2]==0 && matrix_tic_toe[2][0]==2 && matrix_tic_toe[2][1]==0 && matrix_tic_toe[2][2]==0 ) {
				int duongcheo=0;
				while (true) {
					duongcheo = random(1,2);
					if (duongcheo==1 && matrix_tic_toe[0][0]==0 ) {
						x=0;
						y=0;
						break;
					} else if (duongcheo==2 && matrix_tic_toe[2][2]==0) {
						x=2;
						y=2;
						break;
					} 
				}
			}
			if (matrix_tic_toe[1][1]==1 && matrix_tic_toe[0][0]==0 && matrix_tic_toe[0][1]==0 && matrix_tic_toe[0][2]==2 && matrix_tic_toe[1][0]==0 && matrix_tic_toe[1][2]==0 && matrix_tic_toe[2][0]==1 && matrix_tic_toe[2][1]==0 && matrix_tic_toe[2][2]==0 ) {
				int duongcheo=0;
				while (true) {
					duongcheo = random(1,2);
					if (duongcheo==1 && matrix_tic_toe[0][0]==0 ) {
						x=0;
						y=0;
						break;
					} else if (duongcheo==2 && matrix_tic_toe[2][2]==0) {
						x=2;
						y=2;
						break;
					} 
				}
			}
				
			//////////////
			while (matrix_tic_toe[x][y]!=0) {
				x=random(0,2);
				y=random(0,2);
			}
			matrix_tic_toe[x][y]=2;
		}
		
	}
	
	public void demon_generate() {   // sinh ma trận trung bình 
		int count_zero = 0,remember_i = 0,remember_j = 0,sum=0;
		if (check_matrix_empty()==true) {
			////////////// nếu ô ở giữa trống thì đánh vào 
			int x=1;
			int y=1;
			int i,j;
			///////////////   chong thua
			for (i=0;i<3;i++) {
				sum =0 ;
				count_zero = 0;
				for (j=0;j<3;j++) {  ///check hàng ngang 
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==2) {
					x=remember_i;
					y=remember_j;
					break;
				}
				
			}
			for (j=0;j<3;j++) {  // dọc 
				sum =0 ;
				count_zero = 0;
				for (i=0;i<3;i++) {
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==2) {
					x=remember_i;
					y=remember_j;
					break;
				}
			}
			if (matrix_tic_toe[0][0]==0 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][2]==1) {
				x=0;
				y=0;
			} else if (matrix_tic_toe[0][0]==1 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][2]==1) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][0]==1 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][2]==0) {
				x=2;
				y=2;
			} 
			///  đường chéo 
			if (matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][0]==1) {
				x=0;
				y=2;
			} else if (matrix_tic_toe[0][2]==1 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][0]==1) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][2]==1 && matrix_tic_toe[1][1]==1 && matrix_tic_toe[2][0]==0) {
				x=2;
				y=0;
			} 
			//////////////////  thang
			for (i=0;i<3;i++) {
				sum =0 ;
				count_zero = 0;
				for (j=0;j<3;j++) { /// kiểm tra ngang 
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==4) {
					x=remember_i;
					y=remember_j;
					break;
				}
				
			}
			for (j=0;j<3;j++) {  // kiểm tra dọc 
				sum =0 ;
				count_zero = 0;
				for (i=0;i<3;i++) {
					sum+=matrix_tic_toe[i][j];
					if (matrix_tic_toe[i][j]==0) {
						count_zero++;
						remember_i=i;
						remember_j=j;
					}
				}
				if (count_zero==1 && sum==4) {
					x=remember_i;
					y=remember_j;
					break;
				}
			}
			if (matrix_tic_toe[0][0]==0 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][2]==2) {
				x=0;
				y=0;
			} else if (matrix_tic_toe[0][0]==2 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][2]==2) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][0]==2 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][2]==0) {
				x=2;
				y=2;
			} 
			if (matrix_tic_toe[0][2]==0 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][0]==2) {
				x=0;
				y=2;
			} else if (matrix_tic_toe[0][2]==2 && matrix_tic_toe[1][1]==0 && matrix_tic_toe[2][0]==2) {
				x=1;
				y=1;
			} else if (matrix_tic_toe[0][2]==2 && matrix_tic_toe[1][1]==2 && matrix_tic_toe[2][0]==0) {
				x=2;
				y=0;
			} 
			
			
			//////////////
			while (matrix_tic_toe[x][y]!=0) {
				x=random(0,2);
				y=random(0,2);
			}
			matrix_tic_toe[x][y]=2;
		}
		
	}
	public void print_matrix() {
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				System.out.print(matrix_tic_toe[i][j]+" ");
			}
			System.out.println();
		}
	}
}
