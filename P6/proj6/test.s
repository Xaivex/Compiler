	.data
	.align 2
_itest:	.space 4
	.data
	.align 2
_sum:	.space 4
	.data
	.align 2
_btest:	.space 4
	.text
_testIfArithExpr:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 36
		#WRITE
	.data
.L1:	.asciiz "\n//arithmetic ops \n"
	.text
	la    $t0, .L1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -8
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 2
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -12
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sub   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -8
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	add   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -8
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	div   $t0, $t1
	mflo  $t0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -8
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	mult  $t0, $t1
	mflo  $t0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -8
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	add   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	la    $t1, _sum
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	.data
.L2:	.asciiz "var1 = 4/2 * 2: "
	.text
	la    $t0, .L2
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L3:	.asciiz "\n"
	.text
	la    $t0, .L3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L4:	.asciiz "\n// test (<, >, <=, >=) \n"
	.text
	la    $t0, .L4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L5:	.asciiz "5 >= 3: "
	.text
	la    $t0, .L5
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 5
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sge   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L6:	.asciiz "\n"
	.text
	la    $t0, .L6
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L7:	.asciiz "1 <= 2: "
	.text
	la    $t0, .L7
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 2
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sle   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L8:	.asciiz "\n"
	.text
	la    $t0, .L8
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L9:	.asciiz "7 < 4: "
	.text
	la    $t0, .L9
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 7
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	slt   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L10:	.asciiz "\n"
	.text
	la    $t0, .L10
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L11:	.asciiz "6 > 9: "
	.text
	la    $t0, .L11
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 6
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 9
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sgt   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L12:	.asciiz "\n"
	.text
	la    $t0, .L12
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L13:	.asciiz "\n// test PostInc and PostDec \n"
	.text
	la    $t0, .L13
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	addiu $t0, $fp, -8
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t1, 0($t0)
	add   $t1, $t1, 1
	sw    $t1, 0($t0)
	.data
.L14:	.asciiz "\nvar1++: "
	.text
	la    $t0, .L14
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L15:	.asciiz "\n"
	.text
	la    $t0, .L15
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L16:	.asciiz "\nvar2--: "
	.text
	la    $t0, .L16
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	addiu $t0, $fp, -12
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t1, 0($t0)
	sub   $t1, $t1, 1
	sw    $t1, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t1, 0($t0)
	lw    $t0, -12($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L17:	.asciiz "\n"
	.text
	la    $t0, .L17
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L18:	.asciiz "\n// test AND \n"
	.text
	la    $t0, .L18
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -24
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -24($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 1
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	and   $v0, $t1, $t0
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -28
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	.data
.L19:	.asciiz "c && true: "
	.text
	la    $t0, .L19
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -28($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L20:	.asciiz "\n"
	.text
	la    $t0, .L20
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L21:	.asciiz "c && false: "
	.text
	la    $t0, .L21
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -24($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 0
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	and   $v0, $t1, $t0
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L22:	.asciiz "\n"
	.text
	la    $t0, .L22
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L23:	.asciiz "false && false: "
	.text
	la    $t0, .L23
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 0
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	and   $v0, $t1, $t0
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L24:	.asciiz "\n"
	.text
	la    $t0, .L24
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L25:	.asciiz "\n// test NOT \n"
	.text
	la    $t0, .L25
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L26:	.asciiz "\nbool type (b1 != b2): "
	.text
	la    $t0, .L26
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -32($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -36($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sne   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L27:	.asciiz "\nstring type(\"hello\" != \"world\"): "
	.text
	la    $t0, .L27
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L28:	.asciiz "hello"
	.text
	la    $t0, .L28
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	.data
.L29:	.asciiz "world: "
	.text
	la    $t0, .L29
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sne   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L30:	.asciiz "\n"
	.text
	la    $t0, .L30
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L31:	.asciiz "\n// test OR \n"
	.text
	la    $t0, .L31
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -24
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -28
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -28($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L32:	.asciiz "\n"
	.text
	la    $t0, .L32
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -40
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -40($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	lw    $t0, -24($fp)
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	beq   $t0, 1, or_true
	lw    $t0, -40($fp)
	j     or_end
or_true:
	li    $v0, 1
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
or_end:
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L33:	.asciiz "\n"
	.text
	la    $t0, .L33
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L34:	.asciiz "\n// test equality \n"
	.text
	la    $t0, .L34
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 5
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -16
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 10
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -20
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	.data
.L35:	.asciiz "x == y: "
	.text
	la    $t0, .L35
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -16($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -20($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	seq   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L36:	.asciiz "\n"
	.text
	la    $t0, .L36
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -32
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -36
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	.data
.L37:	.asciiz "b1 == b2: "
	.text
	la    $t0, .L37
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -32($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, -36($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	seq   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L38:	.asciiz "\n"
	.text
	la    $t0, .L38
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	j     .L0
		#FUNCTION EXIT

.L0:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testIf:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sne   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	beq   $t0, 0, .L40
	.data
.L41:	.asciiz "not equal!\n"
	.text
	la    $t0, .L41
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L39
.L40:
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L39
		#FUNCTION EXIT

.L39:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testIfAndWhile:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
.L43:
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 10
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	slt   $t0, $t0, $t1
	beq   $t0, 0, .L45
	b     .L44
.L44:
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 5
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	slt   $t0, $t0, $t1
	beq   $t0, 0, .L47
	b     .L46
.L46:
	.data
.L48:	.asciiz "j is less than 5\n"
	.text
	la    $t0, .L48
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	b     .L47
.L47:
	.data
.L49:	.asciiz "j is greater than or equal to 5\n"
	.text
	la    $t0, .L49
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	addiu $t0, $fp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t1, 0($t0)
	add   $t1, $t1, 1
	sw    $t1, 0($t0)
	j     .L43
.L45:
	j     .L42
		#FUNCTION EXIT

.L42:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testIfElseAndLargNum:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 999
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sge   $t0, $t0, $t1
	beq   $t0, 0, .L52
	b     .L51
.L51:
	.data
.L53:	.asciiz " >= 999: true\n"
	.text
	la    $t0, .L53
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L50
	b     .L52
.L52:
	.data
.L54:	.asciiz " >= 999: false\n"
	.text
	la    $t0, .L54
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L50
		#FUNCTION EXIT

.L50:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testWhile:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
.L56:
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 5
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sle   $t0, $t0, $t1
	beq   $t0, 0, .L58
	b     .L57
.L57:
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L59:	.asciiz "\n"
	.text
	la    $t0, .L59
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	addiu $t0, $fp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t1, 0($t0)
	add   $t1, $t1, 1
	sw    $t1, 0($t0)
	j     .L56
.L58:
	.data
.L60:	.asciiz "Done!\n"
	.text
	la    $t0, .L60
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
		#FUNCTION EXIT

.L55:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testNestedCondStmts:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sgt   $t0, $t0, $t1
	beq   $t0, 0, .L63
	b     .L62
.L62:
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 5
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	slt   $t0, $t0, $t1
	beq   $t0, 0, .L65
	b     .L64
.L64:
	.data
.L66:	.asciiz "Number is less than 5\n"
	.text
	la    $t0, .L66
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	b     .L65
.L65:
	.data
.L67:	.asciiz "Number is greater than or equal to 5\n"
	.text
	la    $t0, .L67
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	b     .L63
.L63:
	.data
.L68:	.asciiz "Number is negative\n"
	.text
	la    $t0, .L68
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
		#FUNCTION EXIT

.L61:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testBigLoop:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 4
		#WRITE
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addiu $t1, $fp, -8
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sw    $t0, 0($t1)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
.L70:
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	slt   $t0, $t0, $t1
	beq   $t0, 0, .L72
	b     .L71
.L71:
	addiu $t0, $fp, -8
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t1, 0($t0)
	add   $t1, $t1, 1
	sw    $t1, 0($t0)
	j     .L70
.L72:
	.data
.L73:	.asciiz "sum = "
	.text
	la    $t0, .L73
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	lw    $t0, -8($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
		#FUNCTION EXIT

.L69:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testReturnInt:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	add   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L74
		#FUNCTION EXIT

.L74:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testReturnBool:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	beq   $t0, 1, .L76
	li    $t0, 1
	j     .L77
.L76:
	li    $t0, 0
.L77:
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L75
		#FUNCTION EXIT

.L75:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
_testRecursive:	# METHOD ENTRY
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sle   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	beq   $t0, 0, .L79
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L78
.L79:
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($fp)
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sub   $t0, $t0, $t1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testRecursive
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t1, 4($sp)	#POP
	addu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	mult  $t0, $t1
	mflo  $t0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $v0, 4($sp)	#POP
	addu  $sp, $sp, 4
	b     .L78
		#FUNCTION EXIT

.L78:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	jr    $ra
	.text
	.globl main
main:		# METHOD ENTRY
__start:
	sw    $ra, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	sw    $fp, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	addu  $fp, $sp, 8
	subu  $sp, $sp, 0
		#WRITE
	.data
.L81:	.asciiz "\n"
	.text
	la    $t0, .L81
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L82:	.asciiz "// test arithmetic \n"
	.text
	la    $t0, .L82
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	jal   _testIfArithExpr
	add   $sp, 0
	.data
.L83:	.asciiz "\n"
	.text
	la    $t0, .L83
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L84:	.asciiz "// test if \n"
	.text
	la    $t0, .L84
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 25
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testIf
	add   $sp, 8
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L85:	.asciiz "\n"
	.text
	la    $t0, .L85
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testIf
	add   $sp, 8
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L86:	.asciiz "\n"
	.text
	la    $t0, .L86
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L87:	.asciiz "\n"
	.text
	la    $t0, .L87
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L88:	.asciiz "// test if and while \n"
	.text
	la    $t0, .L88
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 7
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testIfAndWhile
	add   $sp, 4
	.data
.L89:	.asciiz "\n"
	.text
	la    $t0, .L89
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L90:	.asciiz "// test if else \n"
	.text
	la    $t0, .L90
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 1200
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testIfElseAndLargNum
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	li    $t0, 900
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testIfElseAndLargNum
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	.data
.L91:	.asciiz "\n"
	.text
	la    $t0, .L91
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L92:	.asciiz "// test while \n"
	.text
	la    $t0, .L92
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 2
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testWhile
	add   $sp, 4
	.data
.L93:	.asciiz "\n"
	.text
	la    $t0, .L93
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L94:	.asciiz "// test nested conditional stmts \n"
	.text
	la    $t0, .L94
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 6
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testNestedCondStmts
	add   $sp, 4
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	sub   $t0, $zero, $t0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testNestedCondStmts
	add   $sp, 4
	.data
.L95:	.asciiz "\n"
	.text
	la    $t0, .L95
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L96:	.asciiz "// test big loop \n"
	.text
	la    $t0, .L96
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 100
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testBigLoop
	add   $sp, 4
	.data
.L97:	.asciiz "\n"
	.text
	la    $t0, .L97
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L98:	.asciiz "\n// test int return \n"
	.text
	la    $t0, .L98
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L99:	.asciiz "2 + 3: "
	.text
	la    $t0, .L99
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 2
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testReturnInt
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L100:	.asciiz "\n"
	.text
	la    $t0, .L100
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L101:	.asciiz "\n// test bool return \n"
	.text
	la    $t0, .L101
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L102:	.asciiz "!val (val == true): "
	.text
	la    $t0, .L102
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 1
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testReturnBool
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L103:	.asciiz "\n"
	.text
	la    $t0, .L103
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L104:	.asciiz "\n// test recursive function \n"
	.text
	la    $t0, .L104
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L105:	.asciiz "testRecursive(0): "
	.text
	la    $t0, .L105
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 0
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testRecursive
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L106:	.asciiz "\n"
	.text
	la    $t0, .L106
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L107:	.asciiz "testRecursive(2): "
	.text
	la    $t0, .L107
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 2
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testRecursive
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L108:	.asciiz "\n"
	.text
	la    $t0, .L108
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L109:	.asciiz "testRecursive(3): "
	.text
	la    $t0, .L109
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 3
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testRecursive
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L110:	.asciiz "\n"
	.text
	la    $t0, .L110
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L111:	.asciiz "testRecursive(4): "
	.text
	la    $t0, .L111
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	li    $t0, 4
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	jal   _testRecursive
	add   $sp, 4
	sw    $v0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 1
	move  $a0, $t0
	syscall
	.data
.L112:	.asciiz "\n"
	.text
	la    $t0, .L112
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L113:	.asciiz "Hello world!"
	.text
	la    $t0, .L113
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	.data
.L114:	.asciiz "\n"
	.text
	la    $t0, .L114
	sw    $t0, 0($sp)	#PUSH
	subu  $sp, $sp, 4
	lw    $t0, 4($sp)	#POP
	addu  $sp, $sp, 4
	li    $v0, 4
	move  $a0, $t0
	syscall
	j     .L80
		#FUNCTION EXIT

.L80:
_main_Exit:
	lw    $ra, 0($fp)
	move  $t0, $fp
	lw    $fp, -4($fp)
	move  $sp, $t0
	li    $v0, 10
	syscall
