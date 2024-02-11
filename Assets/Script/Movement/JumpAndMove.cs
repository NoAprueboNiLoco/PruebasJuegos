using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class JumpAndMove : MonoBehaviour
{


    [Header("General")]
    public CharacterController player;
    private Vector3 playerInput = Vector3.zero;
    private Vector3 rotationInput = Vector3.zero;
    private float cameraVerticalAngle;
    public float gravityScale = -20f;

    [Header("Referencias")]
    public Camera playerCamera;

    [Header("Rotation")]
    public float rotationSensibility = 10;

    [Header("Salto")]
    public float jumpHeight = 1.9f;

    [Header("Movimiento")]
    public float playerSpeed = 8f;

    // Start is called before the first frame update
    private void Start()
    {
        player = GetComponent<CharacterController>();
        Cursor.lockState = CursorLockMode.Locked;

    }

    // Update is called once per frame
    private void Update()
    {
        look();
        move();
    }

    private void move(){
        if (player.isGrounded)
        {
            playerInput = Vector3.ClampMagnitude(new Vector3(Input.GetAxis("Horizontal"), 0, Input.GetAxis("Vertical")), 1);
            playerInput = transform.TransformDirection(playerInput) * playerSpeed;

            if (Input.GetButtonDown("Jump"))
            {
                playerInput.y = Mathf.Sqrt(jumpHeight * -2f * gravityScale);
            }
        }
        playerInput.y += gravityScale * Time.deltaTime;
        player.Move(playerInput * Time.deltaTime);
    }

    private void look(){
        rotationInput.x = Input.GetAxis("Mouse X") * rotationSensibility * Time.deltaTime;
        rotationInput.y = Input.GetAxis("Mouse Y") * rotationSensibility * Time.deltaTime;

        cameraVerticalAngle = cameraVerticalAngle + rotationInput.y;
        cameraVerticalAngle = Mathf.Clamp(cameraVerticalAngle, -70, 70);

        transform.Rotate(Vector3.up * rotationInput.x);
        playerCamera.transform.localRotation = Quaternion.Euler(-cameraVerticalAngle, 0, 0);
    }
}